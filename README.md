###meta-bananapi

Un-Official OpenEmbedded layer for bananapi boards.

Due to the linux sunxi did not merge the kernel and uboot changes made by Lemaker.

So we make some changes on meta-sunxi and add this new layer to make OE works for bananapi.

This layer depends on the additional layer:

meta-sunxi: https://github.com/xleng/meta-sunxi

meta-openembedded: git://git.openembedded.org/meta-openembedded

meta-qt5: https://github.com/meta-qt5/meta-qt5

Tested with core-image-minimal based on yocto 1.6


###Build minimal image

The following steps has just been tested under ubuntu 12.04 and it may also works on others *nix like OS.


####Install the essential packages
```shell
$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath libsdl1.2-dev xterm
```

####Get poky-daisy-11.0.2
```shell
$ wget http://downloads.yoctoproject.org/releases/yocto/yocto-1.6.1/poky-daisy-11.0.2.tar.bz2

$ tar xvjf poky-daisy-11.0.2.tar.bz2

$ cd poky-daisy-11.0.2
```

####Get meta-sunxi 
```shell
$ git clone https://github.com/xleng/meta-sunxi.git
```

####Get meta-bananapi
```shell
$git clone https://github.com/xleng/meta-bananapi.git
```

####Get meta-openembedded
```shell
$git clone -b daisy https://github.com/openembedded/meta-openembedded.git
```

####Set compile config
```shell
$ . ./oe-init-build-env
```
Add meta-sunxi, meta-bananapi, meta-oe layers to ./conf/bblayer.conf, and it wil be something like this:

```diff
--- bblayers.conf.org   2015-04-21 15:06:45.000000000 +0200
+++ bblayers.conf       2015-04-21 14:25:36.000000000 +0200
@@ -9,6 +9,10 @@
   /home/user/poky-daisy-11.0.2/meta \
   /home/user/poky-daisy-11.0.2/meta-yocto \
   /home/user/poky-daisy-11.0.2/meta-yocto-bsp \
+  /home/user/poky-daisy-11.0.2/meta-sunxi \
+  /home/user/poky-daisy-11.0.2/meta-bananapi \
+  /home/user/poky-daisy-11.0.2/meta-openembedded/meta-oe \
+  /home/user/poky-daisy-11.0.2/meta-qt5 \
   "
 BBLAYERS_NON_REMOVABLE ?= " \
   /home/user/poky-daisy-11.0.2/meta \
```

the parent path of poky maybe different in your pc.


And change the machine type to bananapi in ./conf/local.conf
```
MACHINE ??= "bananapi"
```

####Run compile command
```
$ bitbake core-image-minimal
``` 

This will cost a lot of time in your first compile, it will donwload the sources form internet and then compile the sources, so be patient with it.

You will get a image file under **./tmp/deploy/images/bananapi/core-image-minimal-bananapi.sunxi-sdimg**

Flash this image file with your tools to sd card to boot the system.
