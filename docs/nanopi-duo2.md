##Disk 
Create an image that can by written onto a SD card using dd.
Originally written for rasberrypi adapt for the needs of allwinner sunxi based boards
The disk layout used is:

    0                      -> 8*1024                           - reserverd
    8*1024                 ->                                  - arm combined spl/u-boot or aarch64 spl
    40*1024                ->                                  - aarch64 u-boot
    2048*1024              -> BOOT_SPACE                       - bootloader and kernel

sudo dd if=tmp-musl/deploy/images/nanopi-duo2/u-boot-sunxi-with-spl.bin of=/dev/sdb bs=1k seek=8
    
##U-boot

CONFIG_ENV_OFFSET=0x200000


setenv system A
setenv rootfsdev '/dev/mmcblk0p1'
setenv rwdev '/dev/mmcblk1p1'
setenv type 'mmc'
setenv load_dtb 'load ${type} ${mmcdev}:${mmcpart} ${fdt_addr_r} ${system}/nanopi-duo2.dtb'
setenv load_kernel 'load ${type} ${mmcdev}:${mmcpart} ${kernel_addr_r} ${system}/zImage'
setenv fixbootargs 'setenv bootargs console=${console},${baudrate} System=${system} ROOTFSDEV=${rootfsdev} ROOTIMG=${system}/rootfs.squashfs RWDEV=${rwdev} quiet'
setenv boot_kernel 'run load_dtb; run load_kernel; run fixbootargs; bootz ${kernel_addr_r} - ${fdt_addr_r}'




##BT
mkdir /var/run/dbus
if [ ! -d /rw/var/lib ] ; then
	mkdir -p /var/lib
	mkdir -p /rw/var/lib
fi
mount /rw/var/lib /var/lib

hciattach /dev/ttyS2 bcm43xx 115200 flow bdaddr 11:22:33:44:55:66

dbus
/usr/bin/udevadm trigger --type=devices --subsystem-match=sound --action=add
sleep 1 && /usr/libexec/bluetooth/bluetoothd &

#WLAN
modprobe  brcmfmac
wpa_supplicant -B -c/etc/wpa_supplicant.conf -i wlan0

&& sleep 2 && dhclient -i wlan0 &

-->wpa_supplicant.conf
ctrl_interface=/var/run/wpa_supplicant
ctrl_interface_group=0
update_config=1

network={
        ssid="caxapV4"
        key_mgmt=WPA-PSK
        psk="alligator"
}

#Sound 
/usr/bin/udevadm trigger --type=devices --subsystem-match=sound --action=add
su root -c "pulseaudio -D --daemonize --log-target=syslog "
#aplay -D sysdefault:CARD=Codec /rw/b.wav

## load fitImage
setenv bootcmd 'load mmc 0 ${kernel_addr_r} fitImage;bootm ${kernel_addr_r}'
saveenv

#workaround

mknod /dev/tty1 c 4 1
mknod /dev/tty2 c 4 2
mknod /dev/tty3 c 4 3
mknod /dev/tty4 c 4 4
