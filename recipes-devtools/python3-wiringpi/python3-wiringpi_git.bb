SUMMARY = "python3-wiringPi is a python wrapper for WiringPi ODROID"


LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "gitsm://github.com/hardkernel/WiringPi2-Python.git;protocol=git;branch=master"
SRCREV = "180832215099dcf31a2bad186ec495deed9c1922"

S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += "python3-setuptools swig-native"

python() {
    if 'meta-python' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python to be present.')
}

RDEPENDS_${PN} += "wiringpi"