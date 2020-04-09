#!/bin/bash

mk1part.sh ${1}
copy_boot.sh ${1}
copy_rootfs.sh ${1}
