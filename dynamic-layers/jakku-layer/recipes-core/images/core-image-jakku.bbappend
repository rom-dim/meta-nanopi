FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

include generic.inc

IMAGE_INSTALL_append = "\
    can-utils \
    i2c-tools \
    "
