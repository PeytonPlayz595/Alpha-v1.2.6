package net.minecraft.src;

public interface IWorldAccess {
	void func_934_a(int var1, int var2, int var3);

	void func_937_b(int var1, int var2, int var3, int var4, int var5, int var6);

	void playSound(String var1, double var2, double var4, double var6, float var8, float var9);

	void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12);

	void obtainEntitySkin(Entity var1);

	void releaseEntitySkin(Entity var1);

	void func_936_e();

	void playRecord(String var1, int var2, int var3, int var4);

	void func_935_a(int var1, int var2, int var3, TileEntity var4);
}
