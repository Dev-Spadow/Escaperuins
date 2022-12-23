package com.runescape.cache.anim;

import com.runescape.cache.FileArchive;
import com.runescape.cache.def.ItemDefinition;
import com.runescape.io.Buffer;

public final class Animation {

    public static Animation animations[];
    public static int anInt367;
    public int frameCount;
    public int primaryFrames[];
    public int secondaryFrames[];
    public int[] durations;
    public int loopOffset;
    public int interleaveOrder[];
    public boolean stretches;
    public int forcedPriority;
    public int playerOffhand;
    public int playerMainhand;
    public int maximumLoops;
    public int animatingPrecedence;
    public int priority;
    public int replayMode;

    private Animation() {
        loopOffset = -1;
        stretches = false;
        forcedPriority = 5;
        playerOffhand = -1; //Removes shield
        playerMainhand = -1; //Removes weapon
        maximumLoops = 99;
        animatingPrecedence = -1; //Stops character from moving
        priority = -1;
        replayMode = 1;
    }

    public static void init(FileArchive archive) {
        Buffer stream = new Buffer(archive.readFile("seq.dat"));
        int length = stream.readUShort() + 1;
        if (animations == null)
            animations = new Animation[length];
        for (int j = 0; j < length; j++) {
            if (animations[j] == null) {
                animations[j] = new Animation();
            }
            if (j < 7997)
            	animations[j].decode(stream);
            /**
            if (j == 622) {
            	System.out.println("anInt367: " + animations[j].anInt367);
            	System.out.println("frameCount: " + animations[j].frameCount);
            	System.out.println("Primary Frames: ");
            	for (int i = 0; i < animations[j].primaryFrames.length; i++) {
        			System.out.print(animations[j].primaryFrames[i] + ",");
            	}
            	System.out.println("");
            	System.out.println("Secondary Frames: ");
            	for (int i = 0; i < animations[j].secondaryFrames.length; i++) {
        			System.out.print(animations[j].secondaryFrames[i] + ",");
            	}
            	System.out.println("");
            	System.out.println("Durations: ");
            	for (int i = 0; i < animations[j].durations.length; i++) {
        			System.out.print(animations[j].durations[i] + ",");
            	}
            	System.out.println("");
            	System.out.println("loopOffset: " + animations[j].loopOffset);
            	System.out.println("Interleave Order: ");
            	if (animations[j].interleaveOrder != null) {
                	for (int i = 0; i < animations[j].interleaveOrder.length; i++) {
            			System.out.print(animations[j].interleaveOrder[i] + ",");
                	}	
            	}
            	System.out.println("");
            	System.out.println("Stretches: " + animations[j].stretches);
            	System.out.println("forcedPriority: " + animations[j].forcedPriority);
            	System.out.println("playerOffhand: " + animations[j].playerOffhand);
            	System.out.println("playerMainhand: " + animations[j].playerMainhand);
            	System.out.println("maximumLoops: " + animations[j].maximumLoops);
            	System.out.println("animatingPrecedence: " + animations[j].animatingPrecedence);
            	System.out.println("priority: " + animations[j].priority);
            	System.out.println("replayMode: " + animations[j].replayMode);
            } */
            switch (j) {
            	case 7997:
            		animations[j] = new Animation();
            		animations[j].primaryFrames = new int[] {19267585,19267586,19267587,19267588,19267589,19267590,19267591,19267592,19267591,19267592,19267591,19267592,19267591,19267592,19267591,19267591,19267592,19267591,19267592};
            		animations[j].secondaryFrames = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            		animations[j].durations = new int[] {15,4,4,4,12,4,15,15,15,15,15,15,15,15,15,15,15,15,15};
            		animations[j].frameCount = 19;
            		animations[j].anInt367 = 0;
            		animations[j].loopOffset = 2;
            		animations[j].playerMainhand = 26649;
            		animations[j].playerOffhand = 26649;
            		animations[j].maximumLoops = 8;
            		animations[j].forcedPriority = 5;
            		animations[j].priority = 1;
            		animations[j].animatingPrecedence = 1;
            		animations[j].stretches = true;
            		animations[j].replayMode = 1;
            	break;
            }
        }
        System.out.println("Loaded: " + length + " animations");
    }

    public int duration(int i) {
        int j = durations[i];
        if (j == 0) {
            Frame frame = Frame.method531(primaryFrames[i]);
            if (frame != null) {
                j = durations[i] = frame.duration;
            }
        }
        if (j == 0)
            j = 1;
        return j;
    }

    private void decode(Buffer buffer) {        
        while(true) {
            final int opcode = buffer.readUnsignedByte();

            if (opcode == 0) {
                break;
            } else if (opcode == 1) {
                frameCount = buffer.readUShort();
                primaryFrames = new int[frameCount];
                secondaryFrames = new int[frameCount];
                durations = new int[frameCount];

                for (int i = 0; i < frameCount; i++) {
                    durations[i] = buffer.readUShort();
                }

                for (int i = 0; i < frameCount; i++) {
                    primaryFrames[i] = buffer.readUShort();
                    secondaryFrames[i] = -1;
                }

                for (int i = 0; i < frameCount; i++) {
                    primaryFrames[i] += buffer.readUShort() << 16;
                }
            } else if (opcode == 2) {
                loopOffset = buffer.readUShort();
            } else if (opcode == 3) {
                int len = buffer.readUnsignedByte();
                interleaveOrder = new int[len + 1];
                for (int i = 0; i < len; i++) {
                    interleaveOrder[i] = buffer.readUnsignedByte();
                }
                interleaveOrder[len] = 9999999;
            } else if (opcode == 4) {
                stretches = true;
            } else if (opcode == 5) {
                forcedPriority = buffer.readUnsignedByte();
            } else if (opcode == 6) {
                playerOffhand = buffer.readUShort();
            } else if (opcode == 7) {
                playerMainhand = buffer.readUShort();
            } else if (opcode == 8) {
                maximumLoops = buffer.readUnsignedByte();
            } else if (opcode == 9) {
                animatingPrecedence = buffer.readUnsignedByte();
            } else if (opcode == 10) {
                priority = buffer.readUnsignedByte();
            } else if (opcode == 11) {
                replayMode = buffer.readUnsignedByte();
            } else if (opcode == 12) {
                int len = buffer.readUnsignedByte();

                for (int i = 0; i < len; i++) {
                    buffer.readUShort();
                }

                for (int i = 0; i < len; i++) {
                    buffer.readUShort();
                }
            } else if (opcode == 13) {
                int len = buffer.readUnsignedByte();

                for (int i = 0; i < len; i++) {
                    buffer.read24Int();
                }
            }
        }
        if (frameCount == 0) {
            frameCount = 1;
            primaryFrames = new int[1];
            primaryFrames[0] = -1;
            secondaryFrames = new int[1];
            secondaryFrames[0] = -1;
            durations = new int[1];
            durations[0] = -1;
        }

        if (animatingPrecedence == -1) {
            animatingPrecedence = (interleaveOrder == null) ? 0 : 2;
        }

        if (priority == -1) {
            priority = (interleaveOrder == null) ? 0 : 2;
        }
    }

}