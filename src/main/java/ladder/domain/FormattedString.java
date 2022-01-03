package ladder.domain;

import org.apache.commons.lang3.StringUtils;

public class FormattedString {

    private String str;

    public FormattedString(String str) {
        str = applyFormat(str);
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    private String applyFormat (String str) {
        str = StringUtils.deleteWhitespace(str);
        str = StringUtils.substring(str, 0, 5);
        return str;
    }
}