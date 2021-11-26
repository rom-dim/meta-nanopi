SOC_FAMILY ??= ""
include conf/machine/include/soc-family.inc

# Sub-architecture support
MACHINE_SOCARCH_SUFFIX ?= ""

PREFERRED_PROVIDER_virtual/kernel ?= "linux-mainline"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"

KERNEL_IMAGETYPE ?= "zImage"


UBOOT_ENTRYPOINT ?= "0x40008000"
UBOOT_LOADADDRESS ?= "0x40008000"

SPL_BINARY ?= "u-boot-sunxi-with-spl.bin"

SERIAL_CONSOLE ?= "115200 ttyS0"
MACHINE_FEATURES ?= "alsa"
