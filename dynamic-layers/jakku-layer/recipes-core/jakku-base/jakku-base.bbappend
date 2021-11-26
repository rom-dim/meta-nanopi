FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
            file://startup \
            "


do_install_append () {
install -d ${D}/opt
install -m 0755 ${WORKDIR}/startup ${D}/opt/startup
}
