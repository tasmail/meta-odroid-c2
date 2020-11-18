FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://10-odroid.rules"

do_install_append() {
    install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/udev
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 644 ${WORKDIR}/10-odroid.rules ${D}${sysconfdir}/udev/rules.d/10-odroid.rules
}

FILES_${PN} += "${sysconfdir}/udev/rules.d/10-odroid.rules"
