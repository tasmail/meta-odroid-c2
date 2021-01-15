obj-$(CONFIG_MESON_GPIOMEM)	+= meson-gpiomem.o

all:
	$(MAKE) -C $(BUILDDIR) M=$(PWD) modules
clean:
	$(RM) -f meson-gpiomem.c
