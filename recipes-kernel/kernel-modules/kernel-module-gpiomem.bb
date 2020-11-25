SUMMARY = "ODROID C2 gpio mem"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "odroid-c2"

SRC_URI = "
    file://Makefile \
    file://meson-gpiomem.c \
"

S = ${WORKDIR}

inherit module

MESON_GPIOMEM_DEFAULT_KCONFIG = "CONFIG_MESON_GPIOMEM=y"

MESON_GPIOMEM_DEFAULT_FLAGS = "-DCONFIG_MESON_GPIOMEM=1"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C ${STAGING_KERNEL_DIR} \
		M=${S} \
		O=${STAGING_KERNEL_BUILDDIR} \
		EXTRA_DEFINES="${MESON_GPIOMEM_DEFAULT_FLAGS}" \
		${MESON_GPIOMEM_DEFAULT_KCONFIG}
}

do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C ${STAGING_KERNEL_DIR} \
		M=${S} \
		INSTALL_MOD_PATH="${D}" \
		O=${STAGING_KERNEL_BUILDDIR} \
		EXTRA_DEFINES="${MESON_GPIOMEM_DEFAULT_FLAGS}" \
		${MESON_GPIOMEM_DEFAULT_KCONFIG} \
		modules_install
}
