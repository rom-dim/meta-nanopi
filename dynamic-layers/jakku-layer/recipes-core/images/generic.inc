#Overrived this
IMAGE_DEVICE_TABLES := "${THISDIR}/files/device-table-rootfs.txt"

IMAGE_INSTALL_append = "\
    u-boot-fw-utils \
    u-boot-env \
    linux-firmware-bcm43430 \
    rfkill \
    udev \
    wpa-supplicant \
    strace \
    "
