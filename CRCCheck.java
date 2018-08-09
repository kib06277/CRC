public class CRCCheck
{
	public static void main(String[] args)
	{
		byte[] aa = {0x4F,0x45,0x3D,0x30};
		byte[] bb = new byte[2];
		get_crc16(aa, aa.length, bb);
	}

	public static int get_crc16 (byte[] bufData, int buflen, byte[] pcrc)
	{
		int ret = 0;
		int CRC = 0x0000ffff;
		int POLYNOMIAL = 0x0000a001;
		int i, j;

		if (buflen == 0)
		{
			return ret;
		}

		for (i = 0; i < buflen; i++)
		{
			CRC ^= ((int)bufData[i] & 0x000000ff);
			for (j = 0; j < 8; j++)
			{
				if ((CRC & 0x00000001) != 0)
				{
					CRC >>= 1;
					CRC ^= POLYNOMIAL;
				}
				else
				{
					CRC >>= 1;
				}
			}
		}

		System.out.println(Integer.toHexString(CRC));

		return ret;
	}
}  