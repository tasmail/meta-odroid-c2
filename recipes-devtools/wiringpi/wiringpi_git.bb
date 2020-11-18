SUMMARY = "WiringPi is a PIN based GPIO access library written in C for Raspberry Pi. Port for ODROID"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/hardkernel/wiringPi.git;protocol=git;branch=master"
SRCREV = "b7b6d9552572aa7318d1bef215788cf0232e5e8d"

SRC_URI += " \
		file://001_gpio_Makefile.patch \
	"

DEPENDS = "util-linux"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "odroid-c2"

CFLAGS_prepend = "-I${S}/wiringPi -I${S}/devLib -fPIC"

EXTRA_OEMAKE = "\
    'CC=${CC}' \
    'CXX=${CXX}' \
    'LD=${CXX}' \
    'AR=${AR}' \
    'RANLIB=${RANLIB}' \
    \
    'DEBUGFLAGS=' \
    'CPPFLAGS=${CPPFLAGS}' \
    'CXXFLAGS=${CXXFLAGS}' \
    'LDFLAGS=${LDFLAGS}' \
    'CFLAGS=${CFLAGS}' \
    'INCLUDE_DIR=${D}${includedir}' \
    'LIB_DIR=${D}${libdir}' \
    'DESTDIR=${D}/usr' \
    'PREFIX=""' \
    'LDCONFIG=echo' \
    'WIRINGPI_SUID=0' \    
"


do_compile() {
    oe_runmake -C devLib static
    oe_runmake -C wiringPi static
    oe_runmake -C gpio 'LDFLAGS=${LDFLAGS} -L${S}/wiringPi -L${S}/devLib'
}

do_install() {
    oe_runmake -C devLib install-static
    oe_runmake -C wiringPi install-static
    oe_runmake -C gpio install
}
