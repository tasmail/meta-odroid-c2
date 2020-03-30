#Mali userland provides these
PROVIDES_remove_odroid  = "${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'virtual/libgbm virtual/libgles1 virtual/libgles2 virtual/egl virtual/libegl', '', d)}"
do_install_append_odroid () {
    if [ -n "${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'mali', '', d)}" ]; then
        rm -f ${D}/${libdir}/libEGL*
        rm -f ${D}/${libdir}/libGLESv1_CM.*
        rm -f ${D}/${libdir}/libGLESv2.*
        rm -f ${D}/${libdir}/libgbm*
        rm -f ${D}/${libdir}/libwayland-egl*
    fi
}
