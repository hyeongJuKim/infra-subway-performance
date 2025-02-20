package nextstep.subway.support.handlebars;

import com.github.jknack.handlebars.Options;
import nextstep.subway.support.version.SubwayVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

/**
 * 캐싱 무효화를 위한 Handlerbars.java template engine Helper
 * Helper가 사용된 곳은 src/main/resources/templates의 include/header.html에서 확인 가능
 */
@HandlebarsHelper
public class SubwayHandlebarsHelper {
    private static final Logger logger = LoggerFactory.getLogger(SubwayHandlebarsHelper.class);

    @Autowired
    private SubwayVersion subwayVersion;

    public String staticUrls(String path, Options options) {
        logger.debug("static url : {}", path);
        return String.format("/resources/%s%s", subwayVersion.getVersion(), path);
    }
}
