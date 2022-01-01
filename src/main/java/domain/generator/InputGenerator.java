package domain.generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public abstract class InputGenerator {
	protected static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	protected static List<String> stringTokenizerToList(StringTokenizer st) {
		List<String> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		return list;
	}
}
