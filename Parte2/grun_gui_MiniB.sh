#!/bin/bash

alias grun='java org.antlr.v4.gui.TestRig'

if [ -z "$1" ]; then
  echo "Usage: $0 <input_file>"
  exit 1
fi

grun MiniB programa -gui "$1"
