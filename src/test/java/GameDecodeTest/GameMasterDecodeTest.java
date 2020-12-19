package GameDecodeTest;

import POGOProtos.Rpc.*;
import com.google.protobuf.util.*;
import org.junit.*;

import java.io.*;

public class GameMasterDecodeTest {
	@Test
	public void TestFirmwareGameMasterDecode() throws Exception {
		try (InputStream is = getClass().getResourceAsStream("versions/latest/v2_GAME_MASTER.protobuf")) {
			DownloadGmTemplatesResponseProto response = DownloadGmTemplatesResponseProto.parseFrom(is);
			JsonFormat.Printer printer = JsonFormat.printer();
			try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("target/test-classes/v2_GAME_MASTER.json"))) {
				printer.appendTo(response, writer);
			}
		}
	}
}
