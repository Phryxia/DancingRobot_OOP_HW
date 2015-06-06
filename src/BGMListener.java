/**
 * Observer pattern to recognize bgm changing event.
 * 
 * For example, some robot parts can have their own
 * draw method which is dependent on FFT.
 * But when program is started, there is no music
 * assigned to the BGM, so you have to change them
 * on runtime.
 * 
 * This is very difficult with using normal variable
 * passing way. So we're gonna use BGMListener to
 * sensor the changes about BGM.
 * 
 * @author Se-Kyu-Kwon
 */
public interface BGMListener
{
	public abstract void musicStarted(BGM bgm);
	public abstract void musicStopped(BGM bgm);
	public abstract void musicChanged(BGM bgm);
}
