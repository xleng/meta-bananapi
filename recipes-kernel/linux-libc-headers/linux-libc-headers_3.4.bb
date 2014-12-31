require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR = "r0"

SRCREV = "090b16927f028ce73a2cde2c05df4a78d7294c1a"
SRC_URI = "git://github.com/LeMaker/linux-sunxi.git;protocol=git;branch=lemaker-3.4 \
         "
S = "${WORKDIR}/git"
