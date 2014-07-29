###meta-bananapi

Un-Official OpenEmbedded layer for bananapi boards.

Due to the linux sunxi did not merge the kernel and uboot changes made by Lemaker.

So we make some changes on meta-sunxi and add this new layer to make OE works for bananapi.

This layer depends on the additional layer:

meta-sunxi: https://github.com/xleng/meta-sunxi

meta-openembedded: git://git.openembedded.org/meta-openembedded

Tested with core-image-minimal based on yocto 1.6


###Build minimal image

The following steps has just been tested under ubuntu 12.04 and it may also works on others *nix like OS.


####Install the essential packages

$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
     build-essential chrpath libsdl1.2-dev xterm


####Get poky-daisy-11.0.0

$wget http://downloads.yoctoproject.org/releases/yocto/yocto-1.6.1/poky-daisy-11.0.1.tar.bz2

$tar xvjf poky-daisy-11.0.0.tar.bz2

$cd poky-daisy-11.0.0


####Get meta-sunxi 

$git clone https://github.com/xleng/meta-sunxi.git


####Get meta-bananapi

$git clone https://github.com/xleng/meta-bananapi.git


####Get meta-openembedded

$git clone -b daisy https://github.com/openembedded/meta-openembedded.git


####Set compile config

$source ./oe-init-build-env

Add meta-sunxi, meta-bananapi, meta-oe layers to ./conf/bblayer.conf, and it wil be something like this:

$cat ./conf/bblayers.conf
\# LAYER_CONF_VERSION is increased each time build/conf/bblayers.conf
\# changes incompatibly
LCONF_VERSION = "6"

BBPATH = "${TOPDIR}"
BBFILES ?= ""

BBLAYERS ?= " \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta-yocto \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta-yocto-bsp \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta-sunxi \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta-bananapi \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta-openembedded/meta-oe \
"
BBLAYERS_NON_REMOVABLE ?= " \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta \
/home/john/opensource/yocto/poky-daisy-11.0.0/meta-yocto \
"

the parent path of poky maybe different in your pc.


And change the machine type to bananapi in ./conf/local.conf

MACHINE ??= "bananapi"


####Run compile command
$bitbake core-image-minimal

This will cost a lot of time in your first compile, it will donwload the sources form internet and then compile the sources, so be patient.

You will get a image file under './tmp/deploy/images/bananapi/core-image-minimal-bananapi.sunxi-sdimg'.

Flash this image file with your tools to sd card to boot the system.
