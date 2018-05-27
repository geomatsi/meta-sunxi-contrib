SUMMARY = "Kernel module for xr819 WiFi chip"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"
LICENSE = "GPLv2"

SRCREV = "3ffc0f729454a5d118d6118974ae925beeb521c1"

DEPENDS = "virtual/kernel"

inherit module

COMPATIBLE_MACHINE = "orange-pi-zero"

PKGV = "${KERNEL_VERSION}"
PV = "1.1+git${SRCPV}"
PR = "r0"

SRC_URI = "git://github.com/geomatsi/xradio.git;protocol=https"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "-C ${STAGING_KERNEL_DIR} M=${S}"

RDEPENDS_${PN} += " \
	armbian-firmware-xr819 \
	"
