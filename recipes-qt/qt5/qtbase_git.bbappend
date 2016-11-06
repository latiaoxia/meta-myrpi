DESCRIPTION = "custom qtbase for raspi2"
LICENSE = "MIT"

PACKAGECONFIG_append = " accessibility eglfs gles2"
 
PACKAGECONFIG[eglfs] = "-eglfs -qpa eglfs,-no-eglfs,drm"

DEPENDS_append_${PN} = " userland"

