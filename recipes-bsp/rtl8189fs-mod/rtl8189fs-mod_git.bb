SUMMARY = "Kernel module for rtl8189fs WiFi chip"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
LICENSE = "GPLv2"

inherit module

PV = "1.1+git${SRCPV}"
PR = "r0"

SRC_URI = "git://github.com/jwrdegoede/rtl8189ES_linux.git;protocol=https;branch=rtl8189fs \
	   file://0000-modules-install.patch \
           file://0001-enable-monitor-mode.patch \
	   "
SRCREV = "cddb07311ec03157643c44154498c9f2268fc431"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "orange-pi-pc-plus|orange-pi-zero|orangepi-plus2e"

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR} \
		KVER=${KERNEL_VERSION} \
		SUBARCH=${ARCH} \
		ARCH=${ARCH} \
		MODDESTDIR=${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/ \
		CONFIG_RTL8189FS=m \
		"

RDEPENDS_${PN} += " \
	linux-firmware-rtl8192su \
	linux-firmware-rtl8192ce \
	linux-firmware-rtl8192cu \
	linux-firmware-rtl8188 \
	"

RPROVIDES_${PN} += "kernel-module-rtl8189fs"
