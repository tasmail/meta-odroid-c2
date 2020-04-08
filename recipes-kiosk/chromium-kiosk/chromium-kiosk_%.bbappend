do_install_append () {
    ln -sf ./chromium/swiftshader/libGLESv2.so ${D}${libdir}/libGLESv2.so.2
    ln -sf ./chromium/swiftshader/libGLESv2.so ${D}${libdir}/libGLESv2.so.2.0.0
    ln -sf ./chromium/swiftshader/libEGL.so ${D}${libdir}/libEGL.so.1
    ln -sf ./chromium/swiftshader/libEGL.so ${D}${libdir}/libEGL.so.1.0.0
}

FILES_${PN} += " \
    ${libdir}/libGLESv2.so.2 \
    ${libdir}/libGLESv2.so.2.0.0 \
    ${libdir}/libEGL.so.1 \
    ${libdir}/libEGL.so.1.0.0 \
"
