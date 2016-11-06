inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git:///home/max/project/linux-rpi-4.4.y/.git;protocol=file;bareclone=1;branch=${KBRANCH}"

LINUX_VERSION ?= "4.4.23"

KBUILD_DEFCONFIG_myrpi2 = "bcm2709_defconfig"

SRCREV="${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_myrpi2 = "myrpi2"

KCONFIG_MODE = "--alldefconfig"

do_configure_prepend() {
    echo "CONFIG_LEGACY_PTYS=y" >> ${B}/.config
}
