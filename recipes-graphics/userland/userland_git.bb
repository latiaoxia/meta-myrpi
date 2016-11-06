# Copyright (C) 2016 max <1213077636@qq.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This repository contains the source code for the ARM side \
               libraries used on Raspberry Pi. These typically are installed in /opt/vc/lib \
               and includes source for the ARM side code to interface to: EGL, mmal, GLESv2,\
               vcos, openmaxil, vchiq_arm, bcm_host, WFC, OpenVG. \
              "

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENCE;md5=0448d6488ef8cc380632b1569ee6d196"

PROVIDES = "virtual/libgles2 \
            virtual/egl"
RPROVIDES_${PN} = "libgles2"

COMPATIBLE_MACHINE = "myrpi2"

SRCREV = "2350bf2511fa49e177fb35c9613eef1b657a7506"
SRC_URI = "git://github.com/raspberrypi/userland.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit cmake pkgconfig
EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release -DCMAKE_EXE_LINKER_FLAGS='-Wl,--no-as-needed' \
                 -DVMCS_INSTALL_PREFIX=${exec_prefix} \
                "

FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "dev-so"
FILES_${PN} += "${libdir}/plugins \
                ${libdir}/*.so \
               "
FILES_${PN}-dev += "${includedir} \
                    ${prefix}/src"
FILES_${PN}-doc += "${datadir}/install"
FILES_${PN}-dbg += "${libdir}/plugins/.debug"

RDEPENDS_${PN} += "bash"
