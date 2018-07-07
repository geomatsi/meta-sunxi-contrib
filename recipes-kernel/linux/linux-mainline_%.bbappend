FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_orange-pi-zero-plus2 += " \
        file://0000-opzp2-spidev.patch \
        file://opzp2.cfg \
        "

SRC_URI_append_orange-pi-zero += " \
        file://0000-opz-spidev.patch \
        file://opz.cfg \
        "
