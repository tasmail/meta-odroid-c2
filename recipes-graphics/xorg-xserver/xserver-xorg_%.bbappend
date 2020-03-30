PACKAGECONFIG_remove  = "glamor"
XSERVER_RRECOMMENDS_remove = "${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'xf86-input-libinput', '', d)}"
