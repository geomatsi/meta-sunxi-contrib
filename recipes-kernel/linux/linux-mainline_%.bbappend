FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_orange-pi-zero-plus2 += " \
        file://0000-opzp2-spidev.patch \
        file://opzp2.cfg \
        "

SRC_URI_append_orange-pi-zero += " \
        file://0000-opz-spidev.patch \
        file://opz.cfg \
        "

do_shared_workdir_append () {
	cd ${B}

	kerneldir=${STAGING_KERNEL_BUILDDIR}
	install -d $kerneldir/scripts
	install -d $kerneldir/scripts/mod
	install -d $kerneldir/scripts/basic

	cp include/config/auto.conf $kerneldir/include/config/auto.conf
	cp scripts/basic/fixdep $kerneldir/scripts/basic/fixdep
	cp scripts/mod/modpost $kerneldir/scripts/mod/modpost
}
