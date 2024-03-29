package net.minecraft.src;

import net.PeytonPlayz585.opengl.GL11;
import net.lax1dude.eaglercraft.EaglerImage;
import net.minecraft.client.Minecraft;

public class TextureWatchFX extends TextureFX {

	public TextureWatchFX(Minecraft minecraft) {
		super(Item.pocketSundial.getIconIndex(null));
		field_4224_h = new int[256];
		field_4223_i = new int[256];
		field_4225_g = minecraft;
		field_1128_f = 1;
		EaglerImage bufferedimage = GL11.loadPNG(GL11.loadResourceBytes("/gui/items.png"));
		int i = (field_1126_b % 16) * 16;
		int j = (field_1126_b / 16) * 16;
		field_4224_h = bufferedimage.getSubImage(i, j, 16, 16).data();
		field_4223_i = GL11.loadPNG(GL11.loadResourceBytes("/misc/dial.png")).data();
	}

	public void func_783_a() {
		double d = 0.0D;
		if (field_4225_g.theWorld != null && field_4225_g.thePlayer != null) {
			float f = field_4225_g.theWorld.getCelestialAngle(1.0F);
			d = -f * 3.141593F * 2.0F;
			if (field_4225_g.theWorld.worldProvider.field_4220_c) {
				d = Math.random() * 3.1415927410125732D * 2D;
			}
		}
		double d1;
		for (d1 = d - field_4222_j; d1 < -3.1415926535897931D; d1 += 6.2831853071795862D) {
		}
		for (; d1 >= 3.1415926535897931D; d1 -= 6.2831853071795862D) {
		}
		if (d1 < -1D) {
			d1 = -1D;
		}
		if (d1 > 1.0D) {
			d1 = 1.0D;
		}
		field_4221_k += d1 * 0.10000000000000001D;
		field_4221_k *= 0.80000000000000004D;
		field_4222_j += field_4221_k;
		double d2 = Math.sin(field_4222_j);
		double d3 = Math.cos(field_4222_j);
		for (int i = 0; i < 256; i++) {
			int j = field_4224_h[i] >> 24 & 0xff;
			int k = field_4224_h[i] >> 16 & 0xff;
			int l = field_4224_h[i] >> 8 & 0xff;
			int i1 = field_4224_h[i] >> 0 & 0xff;
			if (k == i1 && l == 0 && i1 > 0) {
				double d4 = -((double) (i % 16) / 15D - 0.5D);
				double d5 = (double) (i / 16) / 15D - 0.5D;
				int i2 = k;
				int j2 = (int) ((d4 * d3 + d5 * d2 + 0.5D) * 16D);
				int k2 = (int) (((d5 * d3 - d4 * d2) + 0.5D) * 16D);
				int l2 = (j2 & 0xf) + (k2 & 0xf) * 16;
				j = field_4223_i[l2] >> 24 & 0xff;
				k = ((field_4223_i[l2] >> 16 & 0xff) * i2) / 255;
				l = ((field_4223_i[l2] >> 8 & 0xff) * i2) / 255;
				i1 = ((field_4223_i[l2] >> 0 & 0xff) * i2) / 255;
			}
			if (field_1131_c) {
				int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
				int k1 = (k * 30 + l * 70) / 100;
				int l1 = (k * 30 + i1 * 70) / 100;
				k = j1;
				l = k1;
				i1 = l1;
			}
			field_1127_a[i * 4 + 0] = (byte) k;
			field_1127_a[i * 4 + 1] = (byte) l;
			field_1127_a[i * 4 + 2] = (byte) i1;
			field_1127_a[i * 4 + 3] = (byte) j;
		}

	}

	private Minecraft field_4225_g;
	private int field_4224_h[];
	private int field_4223_i[];
	private double field_4222_j;
	private double field_4221_k;
}