SUMMARY = "Armbian Linux firmware"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://xr819/device-xradio.mk;md5=01a5e63ddf60e2a4af5b073cec783bb7"

SRC_URI = "git://github.com/armbian/firmware;branch=master"
SRCREV = "d48638ae83026979d617f80c054f8f239d8945dd"

S = "${WORKDIR}/git"

inherit allarch

# workaround for PACKAGE_CLASSES="package_rpm":
# do not 'own' directories to avoid conflicts with other packages
DIRFILES = "1"

do_compile() {
        :
}

do_install () {
	install -d  ${D}${nonarch_base_libdir}/firmware/
	install -d  ${D}${nonarch_base_libdir}/firmware/xr819/
	install -m 644 ${S}/xr819/*.bin ${D}${nonarch_base_libdir}/firmware/xr819/
}   

PACKAGES =+ "${PN}-xr819" 

FILES_${PN}-xr819 = " \
	${nonarch_base_libdir}/firmware/xr819/boot_xr819.bin \
	${nonarch_base_libdir}/firmware/xr819/fw_xr819.bin \
	${nonarch_base_libdir}/firmware/xr819/sdd_xr819.bin \
"

# Firmware files are generally not ran on the CPU, so they can be
# allarch despite being architecture specific
INSANE_SKIP = "arch"
