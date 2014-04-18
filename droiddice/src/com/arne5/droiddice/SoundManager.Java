package com.arne5.droiddice;
import android.media.SoundPool;

public class SoundManager {

        public static final int SOUND_DICE =1;
        private SoundPool soundPool:
        private HashMap<Integer,Integer> soundPoolMap;

private void initSounds() {
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap<Integer, Integer>();
        soundPoolMap.put(SOUND_DICE, soundPool.load(getContext(), R.raw.explosion, 1));
        }

public void playSound(int sound) {
    /* Updated: The next 4 lines calculate the current volume in a scale of 0.0 to 1.0 */
        AudioManager mgr = (AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
        float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
        float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = streamVolumeCurrent / streamVolumeMax;

    /* Play the sound with the correct volume */
        soundPool.play(soundPoolMap.get(sound), volume, volume, 1, 0, 1f);
        }

public void dice() {
        playSound(SOUND_DICE);
        }