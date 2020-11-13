DESCRIPTION = "A library to control Raspberry Pi GPIO channels"
HOMEPAGE = "https://projects.drogon.net/raspberry-pi/wiringpi/"
SECTION = "devel/libs"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI = "\
          git://github.com/hardkernel/wiringPi.git;protocol=git;branch=master-old \
          "

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
