SUMMARY = "python3-wiringPi is a python wrapper for WiringPi ODROID"


LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "gitsm://github.com/hardkernel/WiringPi2-Python.git;protocol=git;branch=master-old"
SRCREV = "e9864451dffeb61c7bbe9881eab2b8931940ae46"

inherit setuptools3

DEPENDS += "python3-setuptools swig wiringpi"

python() {
    if 'meta-python' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python to be present.')
}
