SRC_URI_append = " \
        file://dts/ \
        "

do_unpack_dtb(){
  if [ -d "${WORKDIR}/dts" ] 
  then 
    cp -r ${WORKDIR}/dts/* ${S}/arch/arm/boot/dts/
  fi
}

addtask do_unpack_dtb after do_unpack before do_patch
