SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"
#IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} "

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_FEATURES += "package-management "

IMAGE_INSTALL += " systemd-analyze "

#PREFERRED_VERSION_systemd = "208%"
DISTRO_FEATURES_append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_dev_manager = "systemd"
VIRTUAL-RUNTIME_login_manager ?= "systemd"
#VIRTUAL-RUNTIME_initscripts ?= ""

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

