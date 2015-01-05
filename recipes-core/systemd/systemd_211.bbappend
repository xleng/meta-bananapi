#disable lto for systemd to prevent compile error with gcc 4.9.2
CFLAGS += "-fno-lto"
