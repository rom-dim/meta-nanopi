FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	   file://${MACHINE}/ \ 
	   "

	   
do_unpack_machinefiles(){
  cp -rf ${WORKDIR}/${MACHINE}/* ${S}/
}

addtask do_unpack_machinefiles after do_unpack before do_patch

