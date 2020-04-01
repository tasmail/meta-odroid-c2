#Mali userland provides these
#
PROVIDES_remove  = "${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'virtual/libgbm virtual/libgles1 virtual/libgles2 virtual/egl', '', d)}"
do_install_append () {
    if [ -n "${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'mali', '', d)}" ]; then
        rm -f ${D}/${libdir}/libEGL*
        rm -f ${D}/${libdir}/libGLESv1_CM.*
        rm -f ${D}/${libdir}/libGLESv2.*
        rm -f ${D}/${libdir}/libgbm*
        rm -f ${D}/${libdir}/libwayland-egl*
    fi
}

#### PACKAGECONFIG_append_meson-gx = " ${@bb.utils.contains('MACHINE_FEATURES', 'lima', 'kmsro lima panfrost', '', d)}"
