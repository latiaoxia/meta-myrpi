include recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL_append = " kernel-modules"

IMAGE_FEATURES += "ssh-server-openssh"
