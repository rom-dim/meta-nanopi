require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bc-native dtc-native"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"
SRCREV = "050acee119b3757fee3bd128f55d720fdd9bb890"

SRC_URI = "git://git.denx.de/u-boot.git \
            file://fw_env.config \
          "
