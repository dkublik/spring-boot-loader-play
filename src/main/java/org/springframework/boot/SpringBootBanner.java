package org.springframework.boot;/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Default Banner implementation which writes the 'Spring' banner.
 *
 * @author Phillip Webb
 */
class SpringBootBanner implements Banner {

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";

	private static final String[] BANNER = { "",
            ANSI_PURPLE + "------------- New Shiny Banner ------------",
			ANSI_RED + "  .   ____          _            __ _ _",
			ANSI_YELLOW + " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\",
			ANSI_BLUE + "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\",
			ANSI_PURPLE + " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )",
			ANSI_CYAN + "  '  |____| .__|_| |_|_| |_\\__, | / / / /",
			ANSI_GREEN + " =========|_|==============|___/=/_/_/_/" };

	private static final String SPRING_BOOT = ANSI_RED + " :: Spring Boot :: ";

	private static final int STRAP_LINE_SIZE = 42;

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass,
			PrintStream printStream) {
		for (String line : BANNER) {
			printStream.println(line);
		}
		String version = SpringBootVersion.getVersion();
		version = (version == null ? "" : " (v" + version + ")");
		String padding = "";
		while (padding.length() < STRAP_LINE_SIZE
				- (version.length() + SPRING_BOOT.length())) {
			padding += " ";
		}

		printStream.println(AnsiOutput.toString(AnsiColor.GREEN, SPRING_BOOT,
				AnsiColor.DEFAULT, padding, AnsiStyle.FAINT, version));
		printStream.println(ANSI_RESET);
	}

}
