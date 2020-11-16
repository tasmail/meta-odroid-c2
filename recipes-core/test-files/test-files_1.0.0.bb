SUMMARY = "Test receipt to check the bitbake"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://hello-world \
"

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/default
    install -m 0755 hello-world ${D}${sysconfdir}/default/hello-world
}

FILES_${PN} = " \
    ${sysconfdir} \
"
