SUMMARY = "WiringPi is a PIN based GPIO access library written in C for Raspberry Pi. Port for ODROID"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/hardkernel/wiringPi.git;protocol=git;branch=master-old"
SRCREV = "c5071094acdc00a9a39e0bb9307a5fd7cf3972fd"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "odroid-c2"

CFLAGS_prepend = "-I${S}/wiringPi"

EXTRA_OEMAKE += "'INCLUDE_DIR=${D}${includedir}' 'LIB_DIR=${D}${libdir}'"
EXTRA_OEMAKE += "'DESTDIR=${D}/usr' 'PREFIX=""'"

do_compile() {
    oe_runmake -C wiringPi
    oe_runmake -C devLib
    oe_runmake -C gpio 'LDFLAGS=${LDFLAGS} -L${S}/wiringPi'
}

do_install() {
    oe_runmake -C wiringPi install
    oe_runmake -C devLib install
    oe_runmake -C gpio install
}
