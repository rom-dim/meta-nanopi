SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel
require linux-machines.inc

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

DESCRIPTION = "Mainline Longterm Linux kernel"
DEPENDS += " lz4-native"

RDEPENDS_${KERNEL_PACKAGE_NAME}-base = ""

SRC_URI[md5sum] = "a3820e9aa56af51c0331b7f427e6f71b"
SRC_URI[sha256sum] = "21626132658dc34cb41b7aa7b80ecf83751890a71ac1a63d77aea9d488271a03"


SRC_URI = "https://www.kernel.org/pub/linux/kernel/v5.x/linux-${PV}.tar.xz \
        file://defconfig \
        "

S = "${WORKDIR}/linux-${PV}"
SRC_URI_append_use-mailine-graphics = " file://drm.cfg"
