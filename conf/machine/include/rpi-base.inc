require rpi-default-providers.inc
require rpi-default-versions.inc
require rpi-default-settings.inc 

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-input-keyboard \
           ${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "xf86-video-modesetting", "xf86-video-fbdev", d)} \
           "

MACHINE_EXTRA_RRECOMMENDS = " kernel-modules kernel-devicetree"

EXTRA_IMAGEDEPENDS += "u-boot"

IMAGE_FSTYPES += "tar.bz2"

SERIAL_CONSOLES = "115200;ttyAMA0"

KERNEL_IMAGETYPE = "zImage"
KERNEL_DEVICETREE = "bcm2709-rpi-2-b.dtb \
                    "

UBOOT_SUFFIX = "bin"

# Raspberry Pi has no hardware clock
MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"

MACHINE_FEATURES = "apm keyboard usbhost vfat alsa"

IMAGE_BOOT_FILES ?= "u-boot.${UBOOT_SUFFIX}"

