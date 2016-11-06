require rpi2-basic-image.bb 

IMAGE_INSTALL_append = " \
    openssh-sftp-server \
    qtbase \
    qtbase-plugins \
    "
inherit populate_sdk populate_sdk_qt5
