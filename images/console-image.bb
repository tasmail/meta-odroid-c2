SUMMARY = "A console image customized for the odroid-c2"
HOMEPAGE = "http://www.maxcrc.de"

require images/basic-dev-image.bb

IMAGE_INSTALL += " \
    root-upgrader \
    u-boot-scr \
"

export IMAGE_BASENAME = "console-image"
