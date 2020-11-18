FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://10-odroid.rules"

do_install_append() {
    install -D ${D}${sysconfdir}
    install -D ${D}${sysconfdir}/udev
    install -D ${D}${sysconfdir}/udev/rules.d
    install -Dpm 644 10-odroid.rules ${D}${sysconfdir}/udev/rules.d/10-odroid.rules
}

FILES_${PN} += "${sysconfdir}/udev/rules.d/10-odroid.rules"
