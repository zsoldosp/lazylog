#!/bin/sh
if [[ "$JAVA_HOME" -eq "" ]]; then
	export JAVA_HOME="/c/Program Files/Java/jdk1.6.0_17/"
	export ANT_HOME="/e/lib/apache-ant-1.8.0/"
	export PATH=$PATH:$ANT_HOME/bin:$JAVA_HOME
fi
ant
