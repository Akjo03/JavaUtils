package io.github.akjo03.util.audio;

import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public final class AudioPlayer {
	private AudioPlayer() {}

	private static final int BUFFER_SIZE = 128000;

	public static void play(byte[] audio) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(audio));
		play(audioStream);
	}

	public static void play(File audio) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
		play(audioStream);
	}

	private static void play(@NotNull AudioInputStream audioStream) throws LineUnavailableException {
		AudioFormat audioFormat = audioStream.getFormat();
		DataLine.Info audioInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
		SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(audioInfo);
		sourceLine.open(audioFormat);
		sourceLine.start();

		int nBytesRead = 0;
		byte[] abData = new byte[BUFFER_SIZE];
		while (nBytesRead != -1) {
			try {
				nBytesRead = audioStream.read(abData, 0, abData.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (nBytesRead >= 0) {
				@SuppressWarnings("unused")
				int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
			}
		}
		sourceLine.drain();
		sourceLine.close();
	}
}